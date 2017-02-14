//	README
//	Statement like 'text!./home/index.html' creates a namespace for html files
//  and  it is converted into javascript template using text library.
define([
	'angular',

	'text!./root/root.html',

	'./header/HeaderController',
	'text!./header/index.html',

	'./footer/FooterController',
	'text!./footer/index.html',

	'./login/LoginController',
	'text!./login/index.html',

	'./error/ErrorController',
	'text!./error/index.html',

	'./dashboard/DashboardController',
	'text!./dashboard/index.html',

	'./dashboard/member/MemberController',
	'text!./dashboard/member/index.html',
	'./dashboard/member/MemberListController',
	'text!./dashboard/member/members.list.html',
	'./dashboard/member/MemberAddController',
	'text!./dashboard/member/members.add.html',
	'./dashboard/member/MemberEditController',
	'text!./dashboard/member/member.edit.html',

	'./dashboard/events/EventController',
    'text!./dashboard/events/index.html',
    './dashboard/events/EventListController',
    'text!./dashboard/events/event.list.html',
    './dashboard/events/EventAddController',
    'text!./dashboard/events/event.add.html',
    './dashboard/events/EventEditController',
    'text!./dashboard/events/event.edit.html',

    './dashboard/album/AlbumController',
    'text!./dashboard/album/index.html',
    './dashboard/album/AlbumListController',
    'text!./dashboard/album/album.list.html',
    './dashboard/album/AlbumEditController',
    'text!./dashboard/album/album.edit.html',
    './dashboard/album/AlbumAddController',
    'text!./dashboard/album/album.add.html',

    './dashboard/tickets/TicketController',
    'text!./dashboard/tickets/index.html',
    './dashboard/tickets/TicketListController',
    'text!./dashboard/tickets/ticket.list.html',
    './dashboard/tickets/TicketEditController',
    'text!./dashboard/tickets/ticket.edit.html',
    './dashboard/tickets/TicketAddController',
    'text!./dashboard/tickets/ticket.add.html',

    './dashboard/advertisement/AdvertisementController',
    'text!./dashboard/advertisement/index.html',
    './dashboard/advertisement/AdvertisementListController',
    'text!./dashboard/advertisement/advertisement.list.html',
    './dashboard/advertisement/AdvertisementEditController',
    'text!./dashboard/advertisement/advertisement.edit.html',
    './dashboard/advertisement/AdvertisementAddController',
    'text!./dashboard/advertisement/advertisement.add.html'

], function (
	ng,

	rootTemplate,

	HeaderController,
	headerTemplate,

	FooterController,
	footerTemplate,

	LoginController,
	loginTemplate,

	ErrorController,
	errorTemplate,

	DashboardController,
	dashboardTemplate,

	MemberController,
	memberTemplate,
	MemberListController,
	memberList,
	MemberAddController,
	memberAdd,
	MemberEditController,
	memberEdit,

	EventController,
	eventTemplate,
	EventListController,
	eventList,
	EventAddController,
	eventAdd,
	EventEditController,
	eventEdit,

	AlbumController,
	albumTemplate,
	AlbumListController,
	albumList,
	AlbumEditController,
	albumEdit,
	AlbumAddController,
	albumAdd,

	TicketController,
	ticketTemplate,
	TicketListController,
	ticketList,
	TicketEditController,
	ticketEdit,
	TicketAddController,
	ticketAdd,


    AdvertisementController,
	advertisementTemplate,
	AdvertisementListController,
	advertisementList,
	AdvertisementEditController,
	advertisementEdit,
	AdvertisementAddController,
	advertisementAdd



) {
	'use strict';

	ng.module('app.routes',[])
	.config(['$stateProvider', '$urlRouterProvider', '$locationProvider', '$httpProvider' , function( $stateProvider, $urlRouterProvider, $locationProvider , $httpProvider ) {

		// Default state or if unmatched redirect to this state
		$urlRouterProvider.otherwise( '/login' );

		// Now set up the states
		$stateProvider
			.state('root',{
				abstract: true,
				views: {
					'header@root': {
						template: headerTemplate
					},
					'footer@root': {
						template: footerTemplate,
						controller: FooterController
					},
					'': {
						template: rootTemplate
					}
				}
			})
			.state('login',{
			    parent: 'root',
			    url: '/login',
			    template: loginTemplate,
			    controller: LoginController
			})
			.state('error',{
			    parent: 'root',
			    url: '/error',
			    template: errorTemplate,
			    controller: ErrorController
			})
			.state('dashboard',{
			    parent: 'root',
			    abstract: true,
			    url: '/dashboard',
			    template: dashboardTemplate,
			    controller: DashboardController
			})
			.state('dashboard.member',{
			    parent: 'dashboard',
			    url: '/member',
			    template: memberTemplate,
			    controller: MemberController,
			    abstract: true
			})
			.state('dashboard.member.list',{
			    parent: 'dashboard.member',
			    url: '/list',
			    template: memberList,
			    controller: MemberListController
			})
			.state('dashboard.member.add',{
            	parent: 'dashboard.member',
            	url: '/add',
            	template: memberAdd,
            	controller: MemberAddController
            })
            .state('dashboard.member.edit',{
                 parent: 'dashboard.member',
                 url: '/edit/:user',
                 template: memberEdit,
                 controller: MemberEditController,
                 params:{
                       user:{
                       	   value:null,
                       	   squash:true
                       }
                 }
            })
			.state('dashboard.event',{
                parent: 'dashboard',
                url: '/event',
            	template: eventTemplate,
                controller: EventController,
                abstract: true
            })
            .state('dashboard.event.list',{
            	parent: 'dashboard.event',
            	url: '/list',
            	template: eventList,
            	controller: EventListController
            })
            .state('dashboard.event.add',{
                parent: 'dashboard.event',
                url: '/add',
                template: eventAdd,
                controller: EventAddController
            })
            .state('dashboard.event.edit',{
                parent: 'dashboard.event',
                url: '/edit/:id',
                template: eventEdit,
                params: {
                    id:{
                        value:null,
                        squash: true
                    }
                },
                controller: EventEditController
            })
            .state('dashboard.album',{
                parent: 'dashboard',
                url: '/album',
                template: albumTemplate,
                controller: AlbumController,
                abstract: true
            })
            .state('dashboard.album.list',{
                parent: 'dashboard.album',
                url: '/list',
                template: albumList,
                controller: AlbumListController
            })
            .state('dashboard.album.add',{
                parent: 'dashboard.album',
                url: '/add',
                template: albumAdd,
                controller: AlbumAddController
            })
            .state('dashboard.album.edit',{
                parent: 'dashboard.album',
                url: '/edit/:id',
                template: albumEdit,
                params: {
                    id: {
                        value: null,
                        squash: true
                    }
                },
                controller: AlbumEditController
            })
            .state('dashboard.ticket',{
                parent: 'dashboard',
                url: '/ticket',
                template: ticketTemplate,
                controller: TicketController,
                abstract: true
            })
            .state('dashboard.ticket.list',{
                parent: 'dashboard.ticket',
                url: '/list',
                template: ticketList,
                controller: TicketListController
            })
            .state('dashboard.ticket.add',{
                parent: 'dashboard.ticket',
                url: '/add',
                template: ticketAdd,
                controller: TicketAddController
            })
            .state('dashboard.ticket.edit',{
                parent: 'dashboard.ticket',
                url: '/edit/:ticketId',
                template: ticketEdit,
                params: {
                    id: {
                        value: null,
                        squash: true
                    }
                },
                controller: TicketEditController
            })
            .state('dashboard.ad',{
                 parent: 'dashboard',
                 url: '/ad',
                 template: advertisementTemplate,
                 controller: AdvertisementController,
                 abstract: true
             })
             .state('dashboard.ad.list',{
                 parent: 'dashboard.ad',
                 url: '/list',
                 template: advertisementList,
                 controller: AdvertisementListController
             })
             .state('dashboard.ad.add',{
                 parent: 'dashboard.ad',
                 url: '/add',
                 template: advertisementAdd,
                 controller: AdvertisementAddController
             })
             .state('dashboard.ad.edit',{
                 parent: 'dashboard.ad',
                 url: '/edit/:id',
                 template: advertisementEdit,
                 params: {
                     id: {
                         value: null,
                         squash: true
                     }
                 },
                 controller: AdvertisementEditController
             });




	}])
	.run([ '$location' , '$rootScope' , 'localStorageService' , function( $location , $rootScope , localStorageService  ){

        $rootScope.$on('$stateChangeStart' , function() {
            if( !localStorageService.get('user') ) {
                $location.path('/login');
            }else {

            }

        });

	}]);
});