
class CompassGridImg {
	
	public static void make_grid_img(config, ant, dimensions) {
		def images_dir = config.grass?.images_dir
		def compass_path = config.grass?.compass_path ?: 'compass'

		ant.exec(executable: compass_path) {
			arg(line: "--grid-img ${dimensions} --images-dir ${images_dir} --force")
		}
		
	}	
	
}
