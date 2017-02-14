// loads sub modules and wraps them up into the main module
// this should be used for top-level module definitions only
define([
	'angular',
	'uiRouter',
	'ngAnimate',
	'routes',

	'./services/LoginService',
	'./services/AlbumService',
	'./services/MemberService',
	'./services/EventService',
	'./services/TicketService',
	'./services/AdvertisementService',
	'./services/localStorage',

	'./directives/FileModel',

	'./filters/highlight'
], function ( ng ) {
	'use strict';

	var app = ng.module('app', [
        'ui.router',
        'ngAnimate',
        'app.routes',
        'app.loginService',
        'app.albumService',
        'app.memberService',
        'app.eventService',
        'app.ticketService',
        'app.advertisementService',
        'app.localStorage',

        'app.fileModel',

        'app.highlight'
	]);

	ng.bootstrap( document, ['app'] );
});