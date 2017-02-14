define([
	'angular'
], function (
	ng
) {
	'use strict';

	var advertisementService = ng.module('app.advertisementService' , []);

	return advertisementService.factory( 'advertisementService', ['$http',  function ( $http ) {

		// Adding a dev url for local, comment out in index.html before deployment!
		var url = 'http://localhost:8081/ads';

		return {
			add: function ( image , ad ) {
                            var fd = new FormData();
                    		fd.append('file', image);
                    		fd.append('title', ad.title);
                    		fd.append('url', ad.url );
                    		fd.append('description', ad.description);
                            return $http.post(url+"/add", fd, {
                    			transformRequest : ng.identity,
                    			headers : {
                    				'Content-Type' : undefined
                    			}
                    		});
			},

			update: function ( ad ) {
               	return $http.put( url+'/update', ad );
            },

			list: function() {
			    return $http.get( url+'/list' );
			},

			get: function( id ) {
			    return $http.get( url+'/get?id='+id );
			},

			delete: function( id ) {
            	return $http.delete( url+'/delete?id='+id );
            }

		};
	}]);
});
