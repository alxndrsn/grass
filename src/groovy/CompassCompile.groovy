
class CompassCompile {

	public static void compile(config, ant, callback) {
		def sass_dir = config.grass?.sass_dir
		def css_dir = config.grass?.css_dir
		def images_dir = config.grass?.images_dir
		def relative_assets = config.grass?.relative_assets == null ? true : config.compass?.relative_assets
		def output_style = config.grass?.output_style ?: 'compact'

		do_check sass_dir, "sass_dir is not set (GrassConfig.groovy)", callback
		do_check css_dir, "css_dir is not set (GrassConfig.groovy)", callback
		do_check images_dir, "images_dir is not set (GrassConfig.groovy)", callback
		do_check output_style, "output_style is not set (GrassConfig.groovy)", callback

		//org.jruby.Main.main(['-S', 'gem', 'list'] as String[])
		String[] jrubyArgs = [
				'-e', "require 'rubygems';gem 'compass';load Gem.bin_path('compass', 'compass')",
				'compile',
				'--sass-dir', sass_dir,
				'--css-dir',  css_dir,
				'--images-dir', images_dir,
				'--output-style', output_style
				]
		if(relative_assets) jrubyArgs << "--relative-assets"

		println "Calling JRuby with args: ${jrubyArgs}"

		org.jruby.Main.main(jrubyArgs)
	}
	
	protected static void do_check(value, msg, callback) {
		if (!value)
			callback(msg)
	}

}
