'use strict';

var Promise = require( 'es6-promise' ).Promise,
	gulp = require( 'gulp' ),
	es = require( 'event-stream' ),
	jshint = require( 'gulp-jshint' ),
	serve = require( 'gulp-serve' ),
	livereload = require( 'gulp-livereload' ),
	connectLivereload = require( 'connect-livereload' ),
	rimraf = require( 'rimraf' ),
	watch = require( 'gulp-watch' ),
	sass = require( 'gulp-sass' ),
	concat = require( 'gulp-concat' ),
	rename = require( 'gulp-rename' ),
	exec = require( 'child_process' ).exec,
	processhtml = require( 'gulp-processhtml' ),
	replace = require( 'gulp-replace' ),
	uglify = require( 'gulp-uglify' ),
	requireJS = require( 'gulp-requirejs' ),
	cleanCSS = require( 'gulp-clean-css' ),
	autoprefixer = require( 'gulp-autoprefixer' ),
	karma = require('karma'),
	gulpNgConfig = require('gulp-ng-config'),
	modRewrite  = require('connect-modrewrite'),
	Server = require('karma').Server,

	// Revision number and CLI inputs
	currentRevision = null,
	targetDir = process.env.TARGET_DIR


// Compile JS
function getCompiledScript() {
	console.log( '4. Compiling the JavaScript' );

	// Wait for output and cap the result with an end-event
	var done = false,
		result = es.through(function ( file ) {
		if ( done ) {
			throw new Error( 'Error : Cannot output more than one file' );
		}
		done = true;
		this.emit( 'data', file );
		this.emit( 'end' );
	});

	// Prepare temp files for compilation and pipe compilation result into our result-stream
	var rjsTmpDir = '.tmp/rjs-dist';

	rimraf(rjsTmpDir, function () {
		requireJS({
			name: 'app',
			baseUrl: 'app',
			mainConfigFile: 'app/main.js',
			include: ['almond', 'main'], // include map config
			paths: {},
			out: 'app.js'
		}).pipe( result );
	});
	return result;
}

// This function would return images, fonts required for production
function getProductionAssets() {
	console.log( '5. Returning all images and fonts for production' );
	return es.concat(
		gulp.src( 'assets/**/*.{png,jpg,jpeg,gif,webp,svg,woff,eot,swf}' )
	);
}

// This function would return minified css for production purpose
function getProductionCss(  ) {
	console.log( '6. Return minified CSS for production' );
	return es.concat(
		getCompiledStylesheetAsset(  )
	);
}

// Sass compile, minification and auto-prefixer
function getCompiledStylesheetAsset(  ) {

	console.log( 'Started : Saas compilation to css' );

	// Find all Sass files in app folder
	return gulp.src( 'app/styles.scss' )

		// Run the Sass compiler
		.pipe(sass().on('error', function ( e ) {
			console.log( 'Error : The Sass compilation has failed to run, and this is why - ' );
			console.log( e );
		}).on('end',function() {

			// Log to the console so we know the compilation has completed
			console.log( 'Ended : Sass compilation to css' );
			console.log( '===============================' );
			console.log( 'Started : Minification of css' );
		}))

		// Minify the CSS
		.pipe(cleanCSS({

			// Make sure when minifying the output is compatiable with ie8
			compatibility: 'ie8'
		}).on('error',function( e ) {
			console.log( 'Error : The CSS minification has failed to run, and this is why - ' );
			console.log( e );
		}).on('end',function() {
			console.log( 'Ended : Minification of css' );
		}))

		// Autoprefix so we don't have to
		.pipe(autoprefixer({
			browsers: ['last 2 versions', 'safari 5', 'ie 8', 'ie 9'],
			cascade: false
		}))

		// Concatenate minfied CSS
		.pipe( concat( 'app.css' ) );
}

// Serve
gulp.task('serve', ['jshint'], function () {

	// This is the temp directory,
	// created when we run serve task.
	// It contains the compiled css files.
	var previewTmpDir = '.tmp/dev-preview';

	// Creating config.js for local env
	//getEnvModule('local');

	// Listen for changes made on our localhost
	livereload.listen({
		host: 'localhost'
	});

	// Merge the event streams
	es.merge(

		// Watch for changes to JS files and run JS hint
		watch('app/**/*.js', { base: '' })
			.pipe(jshint())
			.pipe(jshint.reporter('default')),

		// Simple notification for static and built assets
		watch([
			'app/**/*.{html,json}',
			'index.html'
		]),

		// Rebuild entire compiled stylesheet when a file has been changed
		watch( 'app/**/*.scss' ).pipe(es.map(function ( e, cb ) {

			// Compile stylesheet
			getCompiledStylesheetAsset(  )
				.pipe(rename({
					dirname: 'assets'
				}))
				.pipe( gulp.dest( previewTmpDir ) )
				.on('data', cb.bind( null, null ));
		}))
	)
	// Run live reload
	.pipe(livereload());

	// Delete the previewTmpDir
	rimraf(previewTmpDir, function () {

		// Then recreate the temp CSS passing the
		var tempFiles = es.concat( getCompiledStylesheetAsset(  ) )
			.pipe(rename(function ( path ) {
				path.dirname = 'assets/' + path.dirname;
			}))
			.pipe( gulp.dest( previewTmpDir ) );

		// When it's finished, connect live reload
		tempFiles.on('end', function () {

			// Listen for port 9000
			serve({
				port: 9000,
				https:false,
				middlewares: [
					modRewrite(['^([^.]+)$ /index.html [L]']),
					connectLivereload()
				],

				// dirname is the root directory on which gulp task is running
				root: [
					__dirname + '/' + previewTmpDir,
					__dirname
				]
			})();
		 });
	});
});

// Get the revision number
gulp.task('rev', function ( cb ) {
	console.log( '1. Getting the revision number' );
	exec('git rev-parse --short HEAD', function ( err, stdout ) {
		currentRevision = stdout.trim();
		cb();
	});
});

// Linting for JS files
gulp.task('jshint', function () {
	console.log( '2. Running jshint to lint all JS files' );
	return gulp.src( 'app/**/*.js' )
		.pipe( jshint() )
		.pipe( jshint.reporter( 'default' ) )
		.pipe( jshint.reporter( 'fail' ) );
});

// Karma tests
gulp.task('test', function ( cb ) {
	var karmaTmpDir = '.tmp/karma-test';

	rimraf(karmaTmpDir, function () {
	  new Server({
			files: [
				{
					pattern: 'app/**/*.js',
					included: false
				},
				 {
					pattern: 'app/**/*.html',
					included: false
				},
				 {
					pattern: 'app/**/*.json',
					included: false
				},
				{
					pattern: 'bower_components/**/*.js',
					included: false
				},
				{
					pattern: 'test/**/*Test.js',
					included: false
				},
				{
					pattern: 'test/main.js',
					included: true
				},
				{
					pattern: 'test/mock.js',
					included: true
				}
			],

			frameworks: [ 'requirejs', 'mocha', 'sinon-chai' ],

			preprocessors: {
				'app/**/*.js': [ 'coverage' ]
			},

			reporters: [ 'dots', 'coverage' ],
			coverageReporter: {
				type: 'text'
			},

			logLevel: 'INFO',

			browsers: [ 'PhantomJS' ],
			captureTimeout: 5000,

			singleRun: true
		}).start();
		cb();
	});
});

// Delete old distribution folder
gulp.task('deleteDistFolder', function ( cb ) {
	console.log('3. Deleting old ' + targetDir + ' folder');
	rimraf( targetDir, function() {});
	cb();
});

// Dist task
// Run rev, jshint, test and deleteDistFolder before the dist task
gulp.task('dist', ['rev', 'jshint', 'deleteDistFolder'], function () {



	// Check we have entered a target directory, otherwise throw error
	if ( !targetDir ) {
		throw new Error( 'Error : Target directory is required' );
	}

	var targetDirStat = null;
	try {
		targetDirStat = fs.statSync( targetDir );
	} catch ( e ) {
		// ignore errors
	}
	if ( targetDirStat ) {
		throw new Error( 'Error : Target directory already exists' );
	}

	// Return the concatenated event stream
	return es.concat(

		// Process html to replace the build/app versions as below
		// Replace the build version in html with the result of our rev task
		gulp.src( 'index.html' )
			.pipe( processhtml() )
			.pipe( replace( '@@BUILD_REV', currentRevision ) ),

		// Get the compiled JS
		// Add the revision number to the end of the file name
		// Minify the JS
		// Strip out any code in the debug statements (dev URL and console.logs)
		// Add 'min' to the file name
		getCompiledScript()
			.pipe(rename({
				suffix: '-' + currentRevision
			}))
			.pipe( uglify(
				{
					compress: {
						global_defs: {
							'debug': false
						}
					}
				}
			))
			.pipe(rename({
				suffix: '.min'
			})),

		// Get the production assets
		// Add these files into their new location
		getProductionAssets()
			.pipe(rename(function ( path ) {
				path.dirname = 'assets' + '/' + path.dirname;
			})),


		// Add the revision number to our file name
		// Add 'min' to the file name
		getProductionCss(  )
			.pipe(rename({
				suffix: '-' + currentRevision
			}))
			.pipe(rename({
				suffix: '.min'
			}))
	)

	// Finish off the dist task in the location entered when command was run
	.pipe( gulp.dest( targetDir ) );
});