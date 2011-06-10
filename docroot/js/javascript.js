function refreshElementWithServedResource(elementId, resourceURL){
	AUI().use('aui-io-request', function(A){
		var node = A.one('#'+elementId);
		node.empty();
		node2 =A.Node.create('<div/>');
		node2.plug(A.Plugin.IO, { uri: resourceURL, method: 'GET', showLoading:false });
		node2.appendTo('#'+elementId);
	});

}