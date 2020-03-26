apiclient = (function() {

    return {
        getAllCases: function (callback) {
            jQuery.get({
                dataType: "json",
                url: "/covid19",
                success: function (data) {
                    callback(data)
                }
            });
        }
    }
})();