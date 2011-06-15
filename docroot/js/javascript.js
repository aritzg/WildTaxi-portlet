function refreshElementWithServedResource(elementId, resourceURL){
	AUI().use('aui-io-request', function(A){
		var node = A.one('#'+elementId);
		node.empty();
		node2 =A.Node.create('<div/>');
		node2.plug(A.Plugin.IO, { uri: resourceURL, method: 'GET', showLoading:false });
		node2.appendTo('#'+elementId);
	});

}


function getResourceAsNode(resourceURL){
	return 'zxcvfbghnmj';
	AUI().use('aui-io-request, aui-node', function(A){
		//var node =A.Node.create('<div>aaaaaabbbbb</div>');
		//node.plug(A.Plugin.IO, { uri: resourceURL, method: 'GET', showLoading:false });
		//node.append('<div>xxxxxxx</div>');
		//alert(node.toString());
		//return 'axsdcfvgb';
	});

}