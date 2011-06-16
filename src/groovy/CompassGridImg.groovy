
class CompassGridImg {
	
	public static void make_grid_img(config, ant, dimensions) {
		def images_dir = config.grass?.images_dir

		org.jruby.Main.main([
				'-e', "require 'rubygems';gem 'compass';load Gem.bin_path('compass', 'compass')",
				'grid-img',
				dimensions, "${images_dir}/grid.png",
				'--force'
				])
	}	
	
}
