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
 - The list of operations supported by this version are
    - Get Contacts
    - Get Contact By Id
    - Insert Contact
    - Update Contact
    - Delete Contact By Id
    - Delete Contact
    - Download Photo By Id
    - Download Photo
    - Update Contact Photo
    - Delete Contact Photo By Id
    - Delete Contact Photo
    - Get Groups
    - Get Group By Name
    - Get Group By Id
    - Add Group
    - Create Group
    - Update Group
    - Delete Group By Id
    - Delete Group
    - Batch Contacts
    - Batch Groups
    - Batch Insert
    - Batch Update
    - Batch Delete

1.7.x
=====
 - Added demo project (Mule Studio Application)
 - Minor fix in wrappers [CLDCONNECT-822]
 - Changed UpdateDateTime getters/setters to Update
 - Added getters/setters to GoogleContactEntry POJO
 - Changed getEmailAddresses and setEmailAddresses signatures. Previously using List<String>, now List<Email>
 - Removed public getWrapped() from GoogleContactBaseEntry and added a static method to get the wrapped entity. This is to prevent the mapping to Ex. object-to-json of the wrapped entity.
