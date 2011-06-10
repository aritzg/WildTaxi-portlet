var delayed;
var millsDelay = 5000;

var lastTime;
var servResourceUrl;


function temporizeRequests(){
	AUI().use('aui-io-request, aui-delayed-task', function(A){
		delayed = new A.DelayedTask(getLastRequests);
		delayed.delay(millsDelay);
	});
}

function getLastRequests(){
	AUI().use('aui-io-request', function(A){	
		//get requests
  		A.io.request(servResourceUrl + '&resType=requests&lastTime=' + lastTime , {
	  		on: {
		   		success: function() {
		   			//TODO:Pintar en el mapa las request obtenidas
		   			var items = this.get('responseData');
		   			var data;
		     		YUI().use("json", function (Y) {
						data = Y.JSON.parse(items);	 
					});
					for (var i = 0; i < data.list.length; i++) {
                 		lastTime=data.list[i].modifiedDate.time;
               		}
		   		}
		   	}
		});		
	});
	delayed.delay(millsDelay);
}