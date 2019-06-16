var myApp=angular.module("myApp",['ngRoute','ngCookies']);

myApp.config(function($routeProvider){
	
	$routeProvider.when("/login",{templateUrl:"c_user/login.html"})
                  .when("/register",{templateUrl:"c_user/register.html"});
})
myApp.run(function($rootScope,$cookieStore)
		{
		console.log("I am in run function");
		if($rootScope.currentUser==undefined)
			{
			$rootScope.currentUser=$cookieStore.get('UserDetail');
			}
		});

