package viktor_chetvertukhin.MyPersonalGallery.exception;

public class ImageNotFoundException extends RuntimeException{
    public ImageNotFoundException(String message){
        super(message);
    }
}
