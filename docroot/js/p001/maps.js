var geocoder;
var dirService;
var directionsDisplay;

var canvas;
var map;


//var for creation of request
var inputFromLat;
var inputFromLng;
var inputFromAddr;
var inputToLat;
var inputToLng;
var inputToAddr;
var distance;

var sourceOrDest = "source"; //possible values "source" "dest"

/*TODO: obtain default point. Geocoder?*/
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
	
	traceRouteInMap(fromLat, fromLng, toLat, toLng);
}

function initRequestCreateMap(mapaCanvas, inFromLat, inFromLng, inFromAddr, inToLat, inToLng, inToAddr, inDistance){

	inputFromLat = inFromLat;
	inputFromLng = inFromLng;
	inputFromAddr = inFromAddr;
	inputToLat = inToLat;
	inputToLng = inToLng;
	inputToAddr = inToAddr;
	distance = inDistance;
	
	dirService = new google.maps.DirectionsService();
	directionsDisplay = new google.maps.DirectionsRenderer();
	
	canvas=mapaCanvas;
	
	var myOptions = {
			zoom: 8,
			center: defaultPoint,
			mapTypeId: google.maps.MapTypeId.ROADMAP 
	};
	
	map = new google.maps.Map(canvas,myOptions);
	
	
	//Listeners
	google.maps.event.addListener(map, 'click', function(event) {
		handleMapClick(event.latLng);
	});
	
}

function traceRouteInMap(fromLat, fromLng, toLat, toLng){
	var result = "OK";
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
							else{
								result = "ERROR";
							}
						}
					);
	return result;
}



function handleMapClick(point){
	
	if(sourceOrDest=='source'){
		inputFromLat.value=point.lat();
		inputFromLng.value=point.lng();
	}
	else{
		inputToLat.value=point.lat();
		inputToLng.value=point.lng();
	}
	refreshView();
	
}

function refreshView(){
	if(traceRouteInMap(inputFromLat.value, inputFromLng.value, inputToLat.value, inputToLng.value)=="OK"){
		var fromPoint = new google.maps.LatLng(inputFromLat.value, inputFromLng.value);
		setAddress(fromPoint, inputFromAddr);
		var toPoint = new google.maps.LatLng(inputToLat.value, inputToLng.value);
		setAddress(toPoint, inputToAddr);
		calculateDistance(fromPoint, toPoint);
	}
	
}

function selectSourceOrDest(sORd){
	sourceOrDest =sORd;
}


function setAddress(point, element){
	geocoder = new google.maps.Geocoder();
	geocoder.geocode({location:point}, function(result, status){
		if(status=='OK'){
			texto='';
			for(i =0; i<result.length; i++){
				if(i==0) texto= result[i].address_components[0].long_name ;
				else texto= texto +', ' + result[i].address_components[0].long_name ;
			}
			if(element!=undefined)element.value= texto;
		}
	});
}


function calculateDistance(fromPoint, toPoint){
	if(fromPoint!=null && toPoint!=null && distance!=undefined){
		var request = {
			origin:fromPoint,
			destination:toPoint,
			travelMode: google.maps.DirectionsTravelMode.DRIVING
		};

		dirService.route(request,
			function(directionsResult, directionsStatus){
				if (directionsStatus == google.maps.DirectionsStatus.OK) {
					directionsDisplay.setDirections(directionsResult);	
					distance.value=directionsResult.routes[0].legs[0].distance.value;
				}
			}
		);
	}
}