# ElasticSearchDemo
Demo application for using the Rest interface into ElasticSearch

Step 1

Install ElasticSearch locally
https://www.elastic.co/downloads/elasticsearch

For windows get the zip file. 
Uncompress the file, and go into the bin directory.
    something like this: C:\elasticsearch-2.4.0\bin
now run the elasticsearch.bat in the bin directory.

This runs the Elasticsearch on your localhost with port 9200
http://localhost:9200

Optionally read this: https://www.elastic.co/guide/en/elasticsearch/reference/current/getting-started.html
it is very useful in understanding what is going on with the demo code.

Step 2

Open STS (or Step -1 install STS) and create the workspace you will be in.
In the top menu file - import - Git - Projects from Git - Clone URI
In the URI text box paste in the clone url from this project. (you will see this in the repository when you browse it)

Step 3

Clone as a general project (this will create a new project for this repo)
When the process is done you will need to convert it to a maven project to do this click on the 
project name ElasticSearchDemo 
now right click and in the context menu select configure then configure as a Maven project.

When that is done, run the poject by right clicking on the project name ElasticSearchDemo and run As Spring Boot App

You will see the app boot up and notice the port number. As of this writing it is set to 8081

Here are the two links you will use for the demo:
NOTE: id can be anything, I just UUID b/c it is easy to use.

http://localhost:8081/logPerson?firstName=Joe&lastName=Smith

which will return something like this:

{
  _index: "person",
  _type: "log",
  _id: "3a1973dd-c27d-4fe7-8fe3-26357d09b8e5",
  _version: 1,
  _shards: {
  total: 2,
  successful: 1,
  failed: 0
  },
  created: true
}
Now you can use the findPerson

http://localhost:8081/findPerson?id=3a1973dd-c27d-4fe7-8fe3-26357d09b8e5

which returns something like this:

{
  _index: "person",
  _type: "log",
  _id: "3a1973dd-c27d-4fe7-8fe3-26357d09b8e5",
  _version: 1,
  found: true,
      _source: {
      firstName: "Joe",
      lastName: "Smith",
      middle: null,
      height: 0,
      age: 0,
      interests: null
      }
}


This is scratching the surface with elasticsearch. Searching and storing data can all be done through JSON and REST

