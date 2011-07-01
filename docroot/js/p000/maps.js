var delayedRequests;
var delayedSideshow;
var millsDelay = 5000;

var lastTimeSideShow = 0;

var paused = true;

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
		var composedRequestURL = resourceURL + '&resType=requests';
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

                 		if(requests[requestId]==undefined){
                 			requests[requestId] = r;
                 			traceRouteInMap(r);
                 			addInfoWindow(r);
                 		}
                 
               		}
					
					
		   		}
		   	}
		});		
	});
	if(!paused)delayedRequests.delay(millsDelay);
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
	//calculate opacity in function of time
	var now = new Date();
	var maxFuture = Math.min(432000000, wtRequest.beginDate.time - now.getTime());
	var opacity = 1.0 - (maxFuture / 432000000.0);
	wtRequest.directionsDisplay = new google.maps.DirectionsRenderer({markerOptions:{visible:false}, preserveViewport: true, polylineOptions:{strokeOpacity:opacity}});
	
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

	var sideShowUrl = resourceURL + '&resType=sideShow&jspPage=/jsp/p000/sideShow.jsp&lastTimeSideShow=' + lastTimeSideShow;
	
	AUI().use('aui-io-request, anim', function(A){
		A.io.request(sideShowUrl, {
			on: {  
				success: function() {
					var node = A.one('#sideShow');
					//node.setContent(this.get('responseData'));
					//TRIMed text
					var htmlText = this.get('responseData').replace(/^\s+/g,'').replace(/\s+$/g,'');
					node.prepend(htmlText);
					
					//UPDATE time
					var now = new Date();
					lastTimeSideShow = now.getTime();
				}    
			}
		});
	});

	
	if(!paused)delayedSideshow.delay(millsDelay);
}


/*PAUSE AND PLAY procedures*/
function play(){
	temporizeRequests();
	temporizeSideShow();
	paused=false;
}

function pause(){
	paused=true;
}



