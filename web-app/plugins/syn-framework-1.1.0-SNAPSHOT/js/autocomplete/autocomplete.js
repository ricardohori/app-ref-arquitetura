var autoComplete = function(){
	
	var jQInput;
	this.init = function(input, area , functionEncodeUrl ,callBackAdd, callBackDelete, hintText, hintOuLista, registrosIniciais, callbackFunctionParam){
        if (typeof callbackFunctionParam == "undefined") {
            callbackFunctionParam = null;
        }

        jQInput = $(input)

		jQInput.tokenInput(functionEncodeUrl, {
	        method: "POST",
			hintText: hintText,
	        noResultsText: "Nenhum resultado encontrado",
	        searchingText: "Procurando...",
	       	theme: "facebook",
	       	preventDuplicates : true,
            hintOuLista: hintOuLista,
	       	tokenValue: "id",
            callbackFunction: callbackFunctionParam,
	       	minChars: 1,
	       	prePopulate: registrosIniciais,
	        onAdd: function (item) {
	        	if(callBackAdd){
	        		callBackAdd(item);	
	        	}        	
				return false;
	        },
	        onDelete: function (item) {
	        	if (callBackDelete){
	        		callBackDelete(item)
	        	}
	        }
	    });

        jQInput = $(input)

		if(area){
			$(area).click(function(e) {
				jQInput.focus();
			});	
		}	
	}
	
	this.add = function (oId , nome) {
		jQInput.tokenInput("add", {id: oId, name: nome});
	}

	this.removeById = function (oId) {
		jQInput.tokenInput("remove", {id: oId});
	}
	
	this.removeByName = function (nome) {
		jQInput.tokenInput("remove", {name: nome});
	}
	
	this.clear = function() {
		jQInput.tokenInput("clear");
	}
	
	this.getAll = function() {
        return jQInput.tokenInput("get");
	}
	
}