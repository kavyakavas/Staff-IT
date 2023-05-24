// Note: Convert this class to concrete class and add implementation (missing body) to all methods. You will remove the word
// `abstract` everywhere. This class is only kept `abstract` for the sake of interview exercise.

public Product{
	String title;
	double price;
	double rating;
	String pathToImages;

	public Product(String title, double price, double rating){
		this.title = title;
		this.price = price;
		this.rating = rating;
		this.pathToImages = null;
	}
	
	public void setPathToImages(String pathToImages){
		this.pathToImages = pathToImages;
	}
}

public Cart{
	String userId;
	List<Product> products;
	
	public Cart(String userId){
		self.userId = userId;
	}

	public addProduct(Product product){
		products.add(product);
	}
}

public class TestMartAppFeatures {
	Product product_1 = new Product("Product_1",10, 1);
	Product product_2 = new Product("Product_2",20, 2);
	Product product_3 = new Product("Product_3",30, 3);
	Product product_4 = new Product("Product_4",40, 4);
	Product product_5 = new Product("Product_5",50, 5);

	Product[] products = Arrays.asList(product_1, product_2, product_3, product_4, product_5);

	Map<String, String> imagesToProducts = new HashMap<>();
	imagesToProducts.put("Product_1","Path_1");
	imagesToProducts.put("Product_2","Path_2");
	imagesToProducts.put("Product_3","Path_3");
	imagesToProducts.put("Product_4","Path_4");
	imagesToProducts.put("Product_5","Path_5");

	Cart cart_1 = new Cart("user_1");
	cart_1.addProduct(product_1);
	cart_1.addProduct(product_2);

	Cart cart_2 = new Cart("user_2");
	cart_2.addProduct(product_2);
	cart_2.addProduct(product_3);

	Cart cart_3 = new Cart("user_3");
	cart_3.addProduct(product_3);
	cart_3.addProduct(product_4);
	cart_3.addProduct(product_5);

	Carts[] carts = Arrays.asList(cart_1, cart_2, cart_3);

	/**
	 * Prints the titles of all products that have a rating less than or equal to the provided criteria.
	 * @param rating The rating threshold.
	 */
	public void getProductTitlesByWorseRating(double rating){
		for(Product product : products)
			if(product.rating <= rating)
				System.out.println(product.title));				
	}

	/**
	 * Returns the cart with the highest total value.
	 * @returns The cart with the highest total value.
	 */
	public Cart getCartWithHighestTotal(){
		Cart cart_with_hightest_total = null;
		int highest_total = 0;
		for(Cart cart : carts){
			current_total = 0;
			for(Product product : cart.products)
				current_total += product.price;
			
			if(current_total > highest_total){
				highest_total = current_total;
				cart_with_hightest_total = cart;
			}
		}
		
		return cart_with_hightest_total;
	}

	/**
	 * Returns the cart with the lowest total value.
	 * @returns The cart with the lowest total value.
	 */
	public abstract Cart getCartWithLowestTotal(){
		Cart cart_with_lowest_total = null;
		int lowest_total = Integer.MAX_VALUE;
		for(Cart cart : carts){
			current_total = 0;
			for(Product product : cart.products)
				current_total += product.price;
			
			if(current_total < lowest_total){
				lowest_total = current_total;
				cart_with_lowtest_total = cart;
			}
		}
		
		return cart_with_lowtest_total;
	}

	/**
	 * Enriches the product information in a user"s cart by adding product images.
	 * The current product information in a cart has limited fields.
	 * This method adds the `images` field for each product in a given user"s cart.
	 * Note: This method only applies to the first element from the `carts[]` JSON response.
	 * @param userId The ID of the user whose cart"s product information will be enriched.
	 * @returns A list of products with enriched information in the user"s cart.
	 */
	public abstract List<Product> addProductImagesToUserCart(Integer userId){
		for(Cart cart : carts){
			if(cart.userId == userId){
				for(Product product : cart.products){
					product.setPathToImages(imagesToProducts.get(product.title));
				}
				return cart.products;
			}
		}
	}


	public static void main(String[] args){
		System.out.println("Call the methods here");
	}
}