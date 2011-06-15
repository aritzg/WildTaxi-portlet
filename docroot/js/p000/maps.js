var delayed;
var millsDelay = 5000;

var lastTime;


var requests=new Array(); //Array to store requests
var requestsURL =''; //MUST be initialized with Liferay resource request URL
var infoWindowURL ='';

function temporizeRequests(resURL){
	requestsURL = resURL;
	AUI().use('aui-io-request, aui-delayed-task', function(A){
		delayed = new A.DelayedTask(getLastRequests);
		delayed.delay(millsDelay);
		getLastRequests();
	});
}

function getLastRequests(){
	AUI().use('aui-io-request', function(A){	
		//get requests
  		A.io.request(requestsURL + '&resType=requests&lastTime=' + lastTime , {
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
               		}
		   		}
		   	}
		});		
	});
	delayed.delay(millsDelay);
}

/*GOOGLE MAPS*/

var geocoder;
var dirService;
//var directionsDisplay;

var canvas;
var map;

var defaultPoint =  new google.maps.LatLng(43.313188, -1.983719);

function initWildMap(mapaCanvas, resURL){

	infoWindowURL = resURL;
	
	geocoder = new google.maps.Geocoder();
	dirService = new google.maps.DirectionsService();
	//directionsDisplay = new google.maps.DirectionsRenderer();

	canvas=mapaCanvas;
	
	var myOptions = {
			zoom: 8,
			center: defaultPoint,
			mapTypeId: google.maps.MapTypeId.ROADMAP 
	};
	
	map = new google.maps.Map(canvas,myOptions);
	
}
function traceRouteInMap(wtRequest){
	point = new google.maps.LatLng((fromLat+toLat)/2.0, (fromLng + toLng)/2.0);

	fromPoint = new google.maps.LatLng(wtRequest.fromLat,wtRequest.fromLng);
	toPoint = new google.maps.LatLng(wtRequest.toLat,wtRequest.toLng);
	wtRequest.directionsDisplay = new google.maps.DirectionsRenderer();
	
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
	addInfoWindow(wtRequest);
}

function addInfoWindow(wtRequest){
	
	var infowindow = new google.maps.InfoWindow();

	AUI().use('aui-io-request', function(A){
		A.io.request(infoWindowURL + '&resType=infoWindow&requestId=' + wtRequest.requestId, {
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

function fullfillInfoWindow(infoURL, infowindow){
	//alert(infoURL);
	AUI().use('aui-io-request', function(A){
		//var node =A.Node.create('<div/>');
		//node.plug(A.Plugin.IO, { uri: infoURL, method: 'GET', showLoading:false });
		//infowindow.setContent(node);
		//alert(node.text());
		A.io.request(infoURL, {
						on: {  
							success: function() {
										infowindow.setContent(this.get('responseData'));
										}    
						}
		});
							
		
		
	});
}
