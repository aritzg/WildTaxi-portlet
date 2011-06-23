var popup=null;
function popUp(url,width, heigth, modal){
	
	AUI().use('aui-dialog', function(A){
		popup = new A.Dialog(
				{
					centered: true,
					height: heigth,
					title: '',
					width: width,
					modal: modal
				}
			).render();	
		popup.plug(
				A.Plugin.IO,
				{
					uri: url
				}
			);
	});
}

function refreshElementWithServedResource(elementId, rURL){
	AUI().use('aui-io-request', function(A){
		var node = A.one('#'+elementId);
		node.empty();
		node2 =A.Node.create('<div/>');
		node2.plug(A.Plugin.IO, { uri: rURL, method: 'GET', showLoading:false });
		node2.appendTo('#'+elementId);
	});
}