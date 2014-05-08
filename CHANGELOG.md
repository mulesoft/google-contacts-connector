Google Contacts Connector Release Notes
==========================================

Date: 12-May-2014

Version: 2.0.0

Supported API versions: Google Contacts API v3 - https://developers.google.com/google-apps/contacts/v3/reference

Supported Mule Runtime Versions: 3.5.0

Closed Issues in this release
------------------------------

 - Upgraded Mule Devkit to 3.5.0.
 - Removed @Optional as it is redundant when used along @Default.
 - Removed deprecated @OAuthInvalidateAccessTokenOn and added @ReconnectOn on the Connector.
 - Added automated test cases. [CLDCONNECT-903]
 - Minor fixes in the wrappers.

1.7.4
=====
 - Removed public getWrapped() from GoogleContactBaseEntry and added a static method to get the wrapped entity. This is to prevent the mapping to Ex. object-to-json of the wrapped entity.

1.7.3
=====
 - Added getters/setters to GoogleContactEntry POJO
 - Changed getEmailAddresses and setEmailAddresses signatures. Previously using List<String>, now List<Email>

1.7.2
=====
 - Changed UpdateDateTime getters/setters to Update

1.7.1
=====
 - Minor fix in wrappers [CLDCONNECT-822]

1.7.0
=====
 - Added demo project (Mule Studio Application)

1.6.0
=====
 - WARNING: the operation signatures of the connector has been changed. This may lead that a Mule Studio project maded with a previous version of the connector stop working.
 - Wrapped entity objects for simplification for all the Operations

1.0.0
=====
 - Initial release