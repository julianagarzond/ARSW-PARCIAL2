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
        },

        getCasesByCountry:function (countryName,callback) {
            jQuery.get({
                dataType:"json",
                url: "/covid19/"+countryName,
                success:function (data) {
                    callback(data)

                }

            });

        }
    }
})();