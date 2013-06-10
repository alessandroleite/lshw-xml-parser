[lshw][lshw] (Hardware Lister) XML Parser [![Build Status](https://travis-ci.org/alessandroleite/lshw-xml-parser.png?branch=master)](https://travis-ci.org/alessandroleite/lshw-xml-parser)
===================

What is it ?
------------

A XML parser for the [lshw][lshw] output.

How use it ?
------------

1. ##### Maven Repository

	See instructions in [Maven Repository](https://github.com/alessandroleite/maven-repository)


2. ##### Usage


	a) Parsing a XML returned by the lshw command.


		Nodes nodes = lshw.parser.xml.Lshw.unmarshall("lshw-output-hardware-description.xml");
	
	Now, we can iterate through the nodes:
	
		for (NodeInfo node: nodes)
		{ 
			System.out.println(node);
		}

	Or we can find a node by its id.

		NodeInfo node = nodes.findNodeByHardwareId("1");

	b. Generating a XML

   		lshw.parser.xml.Lshw.marshall(new NodeInfo("hardware 1"), new NodeInfo("hardware 2"), ...);
   		

	or
	
		lshw.parser.xml.Lshw.marshall(new Nodes());
		

	See the JUnit's class: lshw.types.jaxb.test.JaxbXmlParserTest
	

How contribute
--------------

### Reporting a Bug / Requesting a Feature

To report an issue or request a new feature you just have to open an issue in the repository issue tracker (<https://github.com/alessandroleite/lshw-xml-parser/issues>).

### Contributing some code

To contribute, follow this steps:

 1. Fork this project
 2. Add the progress label to the issue you want to solve (add a comments to say that you work on it)
 3. Create a topic branch for this issue
 4. When you have finish your work, open a pull request (use the issue title for the pull request title)

## License 

The project is licensed under the MIT license. 
Copyright (c) 2013 Contributors

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
"Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

Contributors:
   Alessandro Ferreira Leite - the initial implementation.

[lshw]:(http://ezix.org/project/wiki/HardwareLiSter)
