	/**
	 * Courses Held, popup version
	 *	.creates popup
	 *		.create div
	 *		.load div
	 *	.display popup
	 **/
	jQuery.fn.coursesHeldPopup = function() {
		var field = $(this[0]);
		var args = arguments[0] || {url : false};
		$('<div class="notificationsbox" id="courses_held"></div>')
		.load(args.url + '/' + args.professorId)
		.appendTo('body').bPopup();
	}	
	 
	/**
	 * Used to validate a field
	 **/
	jQuery.fn.validateField = function() {
		var field = $(this[0]);
		var args = arguments[0] || {required : false, numeric: false};
		var required = args.required;
		var numeric = args.numeric;
		
		if(required)
			if(!$(this).val())
				return false;
		
		if(numeric)
			if(isNaN($(this).val()))
				return false;
				
		return true;
	}
	
	/**
	 *	Used to change status of particular input box
	 **/
	jQuery.fn.updateFieldStatus = function() {
		var field = $(this[0]).closest('div.control-group'); // It's your element
		var args = arguments[0] || {message: null};
		var status = args.status;
		var message = args.message;
		$(field).removeClass('error');
		$(field).removeClass('success');
		//$("label[for=" + $(field).attr('id') + "]").html('<strong>' + $("label[for=" + $(field).attr('id') + "] strong").html() + '</strong>');
		if(status == 'error'){
			$(field).addClass('error');
			//$("label[for=" + $(field).attr('id') + "]").html('<span class="red">'+ $("label[for='" + $(field).attr('id') + "']").html() +'</span>');
			//$(field).after('<img src="../assets/images/icons/icon_missing.png" alt="Missing" />');
			if(message != null)
				$(field).next('img').after('<br /><span class="smltxt red">(' + message + ')</span>');
                }else if(status == 'correct'){
			$(field).addClass('success');
			//$("label[for=" + $(field).attr('id') + "]").html('<span class="green">'+ $("label[for='" + $(field).attr('id') + "']").html() +'</span>');
			//$(field).after('<img src="../assets/images/icons/icon_approve.png" alt="Approve" />');
		}
	};
	

     /*
      * Functions that prints notice boxes
      */
     jQuery.fn.message = function(){
        var field = $(this[0]); // It's your element
        var args = arguments[0] || {message: null, closable: false, status: null};
        var status = args.status;
        var message = args.message;
        var closable = args.closable;
        $(field).html("<div class=\"alert alert-block "+ status+"\"><a class=\"close\" data-dismiss=\"alert\">×</a><span>" + message + "</span></div>");
        
     }
 
     /*
      * Shin Debugging Library for ajax
      */
     $(document).ready(function() {
        $.ajaxSetup({
                error:function(x,e){
                    if(x.status==0){
                        alert('You are offline!!\n Please Check Your Network.');
                    }else if(x.status==404){
                        alert('Requested URL not found.');
                    }else if(x.status==500){
                        alert('Internel Server Error.');
                    }else if(e=='parsererror'){
                        //alert('Error.\nParsing JSON Request failed.');
                        alert('Unknow Error.\n'+(x.responseText));
                    }else if(e=='timeout'){
                        alert('Request Time out.');
                    }else {
                        alert('Unknow Error.\n'+(x.responseText));
                    }
                }
        });
     });
     
    /*
     * Alert Override
     */
    
    window.alert = function (message) {
            bootbox.alert(message);
    };