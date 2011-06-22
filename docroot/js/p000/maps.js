var delayedRequests;
var delayedSideshow;
var millsDelay = 5000;

var lastTime;


var localized =true; //If false, gets requests all around the world, if true, gets requests which start point falls within map boundaries in a given time

var requests=new Array(); //Array to store requests
var resourceURL =''; //MUST be initialized with Liferay resource request URL

function temporizeRequests(){
	
	AUI().use('aui-io-request, aui-delayed-task', function(A){
		delayedRequests = new A.DelayedTask(getLastRequests);
		delayedRequests.delay(millsDelay);
		setTimeout('getLastRequests()', 1000);
	});
}

function getLastRequests(){
	AUI().use('aui-io-request', function(A){	
		//get requests
		var composedRequestURL = resourceURL + '&resType=requests&lastTime=' + lastTime;
		if(localized){
			var bounds = map.getBounds();
			composedRequestURL = composedRequestURL + '&swLat=' + bounds.getSouthWest().lat() + '&swLng=' + bounds.getSouthWest().lng() + '&neLat=' + bounds.getNorthEast().lat() +  '&neLng=' + bounds.getNorthEast().lng();
		}
		
  		A.io.request(composedRequestURL , {
	  		on: {
		   		success: function() {
		   			//TODO:Pintar en el mapa las request obtenidas
		   			var items = this.get('responseData');
		   			var data;
		     		YUI().use("json", function (Y) {
						data = Y.JSON.parse(items);	 
					});
		     		
		     		

					for (var i = 0; i < data.list.length; i++) {
                 		if(i == 0){//Store latest request time
                 			lastTime=data.list[i].modifiedDate.time;
                 		}
                 		var requestId = data.list[i].requestId;
                 		var name = data.list[i].name;
                 		var fromLat = data.list[i].fromLat;
                 		var fromLng = data.list[i].fromLng;
                 		var fromAddress = data.list[i].fromAddress;	
                 		var toLat = data.list[i].toLat;
                 		var toLng = data.list[i].toLng;
                 		var toAddress = data.list[i].toAddress;
                 		var distance = data.list[i].distance;
                 		var beginDate = data.list[i].beginDate;
                 		var duration = data.list[i].duration;
                 		var userId = data.list[i].userId;
                 		r = new Request(requestId, name, fromLat, fromLng, fromAddress, toLat, toLng, toAddress, distance, beginDate, duration, userId);
                 		requests[requests.length]=r;
                 		traceRouteInMap(r);
                 		addInfoWindow(r);
               		}
					
					
		   		}
		   	}
		});		
	});
	delayedRequests.delay(millsDelay);
}

/*GOOGLE MAPS*/

var geocoder;
var dirService;
//var directionsDisplay;

var canvas;
var map;

var defaultPoint =  new google.maps.LatLng(43.313188, -1.983719);

function initWildMap(mapaCanvas, resURL){
	resourceURL = resURL;
	
	var now = new Date();
	lastTime = now.getTime();
	
	
	geocoder = new google.maps.Geocoder();
	dirService = new google.maps.DirectionsService();

	canvas=mapaCanvas;
	
	var myOptions = {
			zoom: 11,
			center: defaultPoint,
			mapTypeId: google.maps.MapTypeId.ROADMAP 
	};
	
	map = new google.maps.Map(canvas,myOptions);
	
}
function traceRouteInMap(wtRequest){
	fromPoint = new google.maps.LatLng(wtRequest.fromLat,wtRequest.fromLng);
	toPoint = new google.maps.LatLng(wtRequest.toLat,wtRequest.toLng);
	wtRequest.directionsDisplay = new google.maps.DirectionsRenderer({markerOptions:{visible:false}, preserveViewport: true});
	
	wtRequest.directionsDisplay.setMap(map);
	var request = {
		origin:fromPoint,
		destination:toPoint,
		travelMode: google.maps.DirectionsTravelMode.DRIVING
	};
	
	dirService.route(request,
			function(directionsResult, directionsStatus){
				if (directionsStatus == google.maps.DirectionsStatus.OK) {
					wtRequest.directionsDisplay.setDirections(directionsResult);
				}
			}
		);
}

function addInfoWindow(wtRequest){
	
	var infowindow = new google.maps.InfoWindow();

	AUI().use('aui-io-request', function(A){
		A.io.request(resourceURL + '&jspPage=/jsp/mapInfoWindow.jsp&resType=infoWindow&requestId=' + wtRequest.requestId, {
				on: {  
					success: function() {
								infowindow.setContent(this.get('responseData'));
								}    
				}
		});
	});
	
	
	var marker = new google.maps.Marker({
	    position: new google.maps.LatLng(wtRequest.fromLat,wtRequest.fromLng),
	    map: map
	});
	google.maps.event.addListener(marker, 'click', function() {
	  infowindow.open(map,marker);
	});
}



function temporizeSideShow(){

	AUI().use('aui-delayed-task', function(A){
		delayedSideshow = new A.DelayedTask(getSideShowInfo);
		delayedSideshow.delay(millsDelay);
		getSideShowInfo();
	});
}

function getSideShowInfo(){
	var sideShowUrl = resourceURL + '&resType=sideShow&jspPage=/jsp/p000/sideShow.jsp';
	
	AUI().use('aui-io-request', function(A){
		A.io.request(sideShowUrl, {
			on: {  
				success: function() {
					var node = A.one('#sideShow');
					node.setContent(this.get('responseData'));
							}    
			}
		});
	});

	
	delayedSideshow.delay(millsDelay);
}
