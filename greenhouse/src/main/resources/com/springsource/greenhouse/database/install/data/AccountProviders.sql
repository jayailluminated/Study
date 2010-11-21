insert into ServiceProvider (name, displayName, implementation, apiKey, secret, requestTokenUrl, authorizeUrl, accessTokenUrl) values ('twitter', 'Twitter', 'com.springsource.greenhouse.connect.providers.TwitterServiceProvider', '99126833b772fa204c0e60296208603a71803dd17e700d5c', 'bf278c8c5951763b56b540d1dfcd7c22cc716723035cdf5df1d316edd992084768d839b3e3c7cee7c349c6c17e736bd3', 'https://twitter.com/oauth/request_token', 'https://twitter.com/oauth/authorize?oauth_token={token}', 'https://twitter.com/oauth/access_token');
insert into ServiceProvider (name, displayName, implementation, apiKey, secret, appId) values ('facebook', 'Facebook', 'com.springsource.greenhouse.connect.providers.FacebookServiceProvider', 'db89ecfed3c7f3e212e01b3fc919838ff04049503d8402034b7148d5d3b7976fe4a314a31db0a42d', 'f85145c9f11fd9d920759b89a29c8e3f4ca05864257eeb4e394557f21588ad41a5f44f16242b14d7', 140372495981006);
insert into ServiceProvider (name, displayName, implementation, apiKey, secret, requestTokenUrl, authorizeUrl, accessTokenUrl) values ('linkedin', 'LinkedIn', 'com.springsource.greenhouse.connect.providers.LinkedInServiceProvider', 'b680817df13092345f63212e1509a3f657f3b4d83eb4279e457f289c141aaabad17c95f356521560cdde05637762710effd7e026801b69e2bd8f3ef2c89cb190b1952e6e20ffbdab', '3c85ee7d4ac9b101d48305989cf140395cd97b6e9113a3a1c9412672f82446cc9128cb0060c8461f7bf0b471b6386ef265f01891dac713c650d1516f07a2021c8932c1a833f8f83c', 'https://api.linkedin.com/uas/oauth/requestToken', 'https://www.linkedin.com/uas/oauth/authorize?oauth_token={token}', 'https://api.linkedin.com/uas/oauth/accessToken');
insert into ServiceProvider (name, displayName, implementation, apiKey, secret, requestTokenUrl, authorizeUrl, accessTokenUrl) values ('tripit', 'TripIt', 'com.springsource.greenhouse.connect.providers.TripItServiceProvider', '6e995d2458c8d2e342920f0f2128852c66d63da8a14cc926b76b81e6c038311bf80753a27acd8eed1484cbcc707d3219', 'a1aef751a5512f834a45511fb30386f210ac290ddfe1af0276bf0c632ce19e3abdcaabda86da6313e13d9939521d7283', 'https://api.tripit.com/oauth/request_token', 'https://www.tripit.com/oauth/authorize?oauth_token={token}&oauth_callback=https://greenhouse.springsource.org/connect/tripit', 'https://api.tripit.com/oauth/access_token');