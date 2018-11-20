const m = require('mithril');

const campaigns = require("./view/campaigns");
const createCampaign = require("./view/createCampaign");
const viewCampaign = require("./view/viewCampaign");

m.route(document.body,"/campaigns",{
  "/campaigns":campaigns,
  "/campaign/:campaignId":viewCampaign,
  "/createCampaign":createCampaign
});