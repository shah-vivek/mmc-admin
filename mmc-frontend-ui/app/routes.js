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

    './dashboard/membership/MembershipController',
    'text!./dashboard/membership/index.html',
    './dashboard/membership/MembershipListController',
    'text!./dashboard/membership/membership.list.html',
    './dashboard/membership/MembershipEditController',
    'text!./dashboard/membership/membership.edit.html',
    './dashboard/membership/MembershipAddController',
    'text!./dashboard/membership/membership.add.html',

    './dashboard/advertisement/AdvertisementController',
    'text!./dashboard/advertisement/index.html',
    './dashboard/advertisement/AdvertisementListController',
    'text!./dashboard/advertisement/advertisement.list.html',
    './dashboard/advertisement/AdvertisementEditController',
    'text!./dashboard/advertisement/advertisement.edit.html',
    './dashboard/advertisement/AdvertisementAddController',
    'text!./dashboard/advertisement/advertisement.add.html',

    './dashboard/appHomePage/AppHomePageController',
    'text!./dashboard/appHomePage/index.html',
    './dashboard/appHomePage/AppHomePageListController',
    'text!./dashboard/appHomePage/appHomePage.list.html',
    './dashboard/appHomePage/AppHomePageEditController',
    'text!./dashboard/appHomePage/appHomePage.edit.html',
    './dashboard/appHomePage/AppHomePageAddController',
    'text!./dashboard/appHomePage/appHomePage.add.html',

    './dashboard/presidentCorner/PresidentController',
    'text!./dashboard/presidentCorner/index.html',

    './dashboard/mmc/MMCController',
    'text!./dashboard/mmc/index.html'

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

	MembershipController,
	membershipTemplate,
	MembershipListController,
	membershipList,
	MembershipEditController,
	membershipEdit,
	MembershipAddController,
	membershipAdd,


    AdvertisementController,
	advertisementTemplate,
	AdvertisementListController,
	advertisementList,
	AdvertisementEditController,
	advertisementEdit,
	AdvertisementAddController,
	advertisementAdd,

    AppHomePageController,
    appHomePageTemplate,
    AppHomePageListController,
    appHomePageListTemplate,
    AppHomePageEditController,
    appHomePageEditTemplate,
    AppHomePageAddController,
    appHomePageAddTemplate,

    PresidentController,
    presidentCornerTemplate,

    MMCController,
    mmcTemplate

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
            .state('dashboard.membership',{
                parent: 'dashboard',
                url: '/membership',
                template: membershipTemplate,
                controller: MembershipController,
                abstract: true
            })
            .state('dashboard.membership.list',{
                parent: 'dashboard.membership',
                url: '/list',
                template: membershipList,
                controller: MembershipListController
            })
            .state('dashboard.membership.add',{
                parent: 'dashboard.membership',
                url: '/add',
                template: membershipAdd,
                controller: MembershipAddController
            })
            .state('dashboard.membership.edit',{
                parent: 'dashboard.membership',
                url: '/edit/:membershipId',
                template: membershipEdit,
                params: {
                    id: {
                        value: null,
                        squash: true
                    }
                },
                controller: MembershipEditController
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
             })
             .state('dashboard.appHomePage',{
                 parent: 'dashboard',
                 url: '/appHomePage',
                 template: appHomePageTemplate,
                 controller: AppHomePageController
             })
             .state('dashboard.appHomePage.list',{
                parent: 'dashboard.appHomePage',
                url: '/list',
                controller: AppHomePageListController,
                template: appHomePageListTemplate
             }).state('dashboard.appHomePage.add',{
                parent: 'dashboard.appHomePage',
                url: '/add',
                controller: AppHomePageAddController,
                template: appHomePageAddTemplate
             }).state('dashboard.appHomePage.edit',{
                 parent: 'dashboard.appHomePage',
                 url: '/edit/:id',
                 template: appHomePageEditTemplate,
                 params: {
                     id: {
                         value: null,
                         squash: true
                     }
                 },
                 controller: AppHomePageEditController
             }).state('dashboard.presidentCorner',{
                parent: 'dashboard',
                url: '/presidentCorner',
                template: presidentCornerTemplate,
                controller: PresidentController
             }).state('dashboard.mmc',{
                parent: 'dashboard',
                url: '/mmc',
                template: mmcTemplate,
                controller: MMCController
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