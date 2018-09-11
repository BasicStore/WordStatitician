COMPROMISES + NOTES

- limit to the extent of the data persisted, no
  attempt to persist all data......just the statistically relevant
- user must input, can't decorate the search with inbuilt jobs
  to process all conceivably interesting stats given the processing resources
- limit to how many searches can be done without slowing performance,
  so sarch for one thing or another in WordSearchType definitions
- possible limit to how big the File stream can be passed around
- various options for JVM to JVM communication

X not tested in clustered environment
X even so listeners must be setup and running on other machines
X light on testing 

+ client options
+ how to run main and tests
+ description of arhitecture:
  --> design plan
  --> JMS
  --> threads: ExecutorService
  ==> explain some of the benefits of using spring + hibernate
+ trade off notes
 