var geocoder;
var dirService;
var directionsDisplay;

var canvas;
var map;

var defaultPoint =  new google.maps.LatLng(43.313188, -1.983719);

function initRequestDetailMap(mapaCanvas, fromLat, fromLng, toLat, toLng){

	geocoder = new google.maps.Geocoder();
	dirService = new google.maps.DirectionsService();
	directionsDisplay = new google.maps.DirectionsRenderer();
	

	canvas=mapaCanvas;
	
	var myOptions = {
			zoom: 8,
			center: defaultPoint,
			mapTypeId: google.maps.MapTypeId.ROADMAP 
	};
	
	map = new google.maps.Map(canvas,myOptions);
	
	traceRouteInMap(canvas, fromLat, fromLng, toLat, toLng);
}

function traceRouteInMap(canvas, fromLat, fromLng, toLat, toLng){
	
	point = new google.maps.LatLng((fromLat+toLat)/2.0, (fromLng + toLng)/2.0);

	fromPoint = new google.maps.LatLng(fromLat,fromLng);
	toPoint = new google.maps.LatLng(toLat,toLng);
	var myOptions = {
			zoom: 10,
			center: point,
			mapTypeId: google.maps.MapTypeId.ROADMAP
		};
	
	directionsDisplay.setMap(map);
	var request = {
		origin:fromPoint,
		destination:toPoint,
		travelMode: google.maps.DirectionsTravelMode.DRIVING
	};
	dirService.route(request,
						function(directionsResult, directionsStatus){
							if (directionsStatus == google.maps.DirectionsStatus.OK) {
								directionsDisplay.setDirections(directionsResult);	
							}
						}
					);
}