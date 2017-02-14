define([
	'angular'
], function (
	ng
) {
	'use strict';

	var albumService = ng.module('app.albumService' , []);

	return albumService.factory( 'albumService', ['$http',  function ( $http ) {

		// Adding a dev url for local, comment out in index.html before deployment!
		var url = 'http://localhost:8081/album';

		return {
			add: function ( album ) {
				return $http.post( url, album );
			},
			get: function(){
			    return $http.get(url);
			},
			getAlbum: function( id ){
			    return $http.get('http://localhost:8081/archive/album/'+id);
			},

			upload: function(file, name, albumId , date) {
                    		var fd = new FormData();
                    		fd.append('file', file);
                    		fd.append('person', name);
                    		fd.append('albumId', albumId );
                    		fd.append('date', date);
                    		return $http.post("http://localhost:8081/archive/upload", fd, {
                    			transformRequest : ng.identity,
                    			headers : {
                    				'Content-Type' : undefined
                    			}
                    		});
            }
		};
	}]);
});
