define(['knockout'], function(ko) {

    return {
        displayName: 'Example',
        primaryIds: ko.observableArray([]),
        secondaryIds: ko.observableArray([]),
        selectedPrimaryId: ko.observable(),
        selectedSecondaryId: ko.observable(),
        activate: function() {
            this.allIds = {
                id_1: ['s_id_1', 's_id_2', 's_id_3'],
                id_2: ['s_id_4', 's_id_7', 's_id_10']
            };
            
            var that = this;
            Object.keys(this.allIds).map(function(id) {
                return { id: id, name: id };
            }).forEach(function (item) {
                that.primaryIds.push(item);
            });

            this.selectedPrimaryId.subscribe(function(newValue) {
                var secondary = that.allIds[newValue]
                
                if (secondary) {
                    that.secondaryIds.removeAll();
                    secondary.map(function(item) {
                        return { id: item, name: item };
                    }).forEach(function(item) {
                        that.secondaryIds.push(item);
                    });
                } 
            });
        }
    };
});
