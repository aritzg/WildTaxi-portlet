var requestId;
var name;
var fromLat;
var fromLng;
var fromAddress;
var toLat;
var toLng;
var toAddress;
var distance;
var beginDate;
var duration;
var userId;

var directionsDisplay;



function Request(requestId, name, fromLat, fromLng, fromAddress, toLat, toLng, toAddress, distance, beginDate, duration, userId){
	this.requestId =requestId;
	this.name =name;
	this.fromLat =fromLat;
	this.fromLng =fromLng;
	this.fromAddress =fromAddress;
	this.toLat =toLat;
	this.toLng =toLng;
	this.toAddress =toAddress;
	this.distance =distance;
	this.beginDate =beginDate;
	this.duration =duration;
	this.userId =userId;
}