
class CompassGridImg {
	
	public static void make_grid_img(config, ant, dimensions) {
		def images_dir = config.grass?.images_dir

		org.jruby.Main.main(['-S', 'compass', 'grid-img', dimensions, "${images_dir}/grid.png", '--force'])
	}	
	
}
