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
	'./services/AppHomepageservice',
	'./services/MembershipService',
	'./services/PresidentService',
	'./services/localStorage',

	'./directives/FileModel',
	

	'./filters/highlight',
	'wysiwyg'
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
        'app.appHomePageService',
        'app.membershipTypeService',
        'app.presidentService',
        'app.localStorage',

        'app.fileModel',
		'app.highlight',
		'ngWYSIWYG'
	]);

	ng.bootstrap( document, ['app'] );
});