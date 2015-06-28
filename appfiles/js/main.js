var eventFunc = function(form, responseTag, doneFunc, failFunc) {
    $(form).submit(function(eve) {

        eve.preventDefault();
        var formData = $(form).serialize();

        $.ajax({
                type: 'GET',
                url: $(form).attr('action'),
                data: formData
        })
        .done(doneFunc)
        .fail(failFunc);
    });
}


