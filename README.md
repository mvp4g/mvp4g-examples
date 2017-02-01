#### MVP4G-Examples

To help you understand the framework, Mvp4g comes with tutorials and examples. Here you will find several examples. Most of them are deployed at the app engine.

#### Examples

#####EmployeeAdmin
The GWT PureMvc example (as part of the mvp4g showcase [here](http://mvp4gexsc.appspot.com/)) but implemented with the Mvp4g framework.

#####EmployeeAdmin with GXT:
Same example as EmployeeAdmin but implemented with GXT using different approaches ([see Mvp4g and GXT post](https://groups.google.com/forum/#!topic/mvp4g/W6hmSvu9ofc)).


#####Mvp4gMultiPresenterExample
This example demonstrates the use of the Multi-Presenter feature of mvp4g without using History. 

Once the program is started, you'll see a Dashboard with an empty portlet. This portlet contains the unique IDs of all opened presenter. By pressing the the 'add tab'-button, a new tab is created 
and the unique ID of the presenter is added to the grid of open tabs. Double clicking a row in the will bring the corresponding presenter to front.

The implementation is done with a mvp4g Eventhandler which manages new tabs, open tabs and closing a tab.
