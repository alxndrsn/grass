
class CompassGridImg {
	
	public static void make_grid_img(config, ant, dimensions) {
		def images_dir = config.grass?.images_dir
		def compass_path = config.grass?.compass_path ?: 'compass'

		ant.exec(executable: "compass") {
			arg(line: "grid-img ${dimensions} ${images_dir}/grid.png --force")
		}
		
	}	
	
}
