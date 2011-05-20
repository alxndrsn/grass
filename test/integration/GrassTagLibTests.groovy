import grails.test.*

class GrassTagLibTests extends GroovyPagesTestCase {
	def tagLib = new GrassTagLib()

	void testResourcesWithoutFramework() {
		shouldFail(IllegalArgumentException) {
			tagLib.resources()
		}
	}

	void testResourcesWithBlueprint() {
		assert tagLib.resources(framework:'blueprint')  == '''\
<link href="/css/screen.css" media="screen, projection" rel="stylesheet" type="text/css" />
<link href="/css/print.css" media="print" rel="stylesheet" type="text/css" />
<!--[if lt IE 8]>
	<link href="/css/ie.css" media="screen, projection" rel="stylesheet" type="text/css" />
<![endif]-->
'''
	}

	void testResourcesWithYui() {
		assert tagLib.resources(framework:'yui') == '''\
<link href="/css/screen.css" media="screen, projection" rel="stylesheet" type="text/css" />
'''
	}
}

