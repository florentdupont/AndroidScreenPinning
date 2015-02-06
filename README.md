# Android Screen Pinning

Demo code used for article on Android Screen Pinning with Android Lollipop (API 21).

This Demo is composed of 3 applications : 

* "Authorized Pinning App" and "Unauthorized Pinning App" are the same, they only differ by their packagename. They provide a way to programmatically pin/unpin the application
* DeviceOwnerApp : sets the pinnable application (the "Authorized Pinning app") and reacts to pinning events by displaying toasts and logs when apps are pinned and unpinned. This app as to be set as a Device Admin App to work correctly.
