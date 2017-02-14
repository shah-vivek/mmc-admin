// This is for configuring requireJs stuffs.

// RequireJS paths and shim configuration.
// Declarative-only: does not invoke any actual code.
requirejs.config({
	baseUrl: 'app',
	paths: {
		'angular': '../bower_components/angular/angular',
		'text': '../bower_components/text/text',
		'uiRouter': '../bower_components/angular-ui-router/release/angular-ui-router',
		'almond': '../bower_components/almond/almond',
		'ngAnimate': '../bower_components/angular-animate/angular-animate',
		'pikaday': '../bower_components/pikaday/pikaday',
		'moment': '../bower_components/moment/moment',
		'flatpickr': '../bower_components/flatpickr/dist/flatpickr.min'
	},
	shim: {
		'angular': {
			exports: 'angular'
		},
		'uiRouter':{
			deps: ['angular']
		},
        'ngAnimate':{
         	deps: ['angular']
        }
	}
});