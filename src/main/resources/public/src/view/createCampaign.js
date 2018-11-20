const m = require('mithril');


const formState = {
  id:'',
  name:'',
  setId:function (rank) {
    formState.id = rank
  },
  setName:function (name) {
    formState.name = name;
  }
};

const createCampaign = {
  view:function () {
    return [
      m('h3',"Add Campaign"),
      m("label.label", "Id"),
      m("input.id.input[type=text][placeholder=Id]",{
        oninput: m.withAttr('value',formState.setId)
      }),
      m("label.label", "Name"),
      m("input.name.input[type=text][placeholder=Name]",{
        oninput: m.withAttr('value',formState.setName)
      }),
      m("br"),
      m("button.button[type=submit]",{
        onclick:function () {
          return m.request({
            method: 'post',
            url: '/campaign',
            data: {'id': formState.id, 'name': formState.name}
          }).then(function () {
            window.location = '/'
          })
        }
      }, "Save"),
    ]
  }
};


module.exports = createCampaign;