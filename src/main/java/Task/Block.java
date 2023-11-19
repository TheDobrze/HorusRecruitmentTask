package Task;

import java.util.Optional;
import java.util.function.Predicate;

public interface Block {

    String getColor();
    String getMaterial();

    default int getChildrenCount(){
        return 1;
    }

    default Optional<Block> getMachingObj(Predicate<Block> predicate){
        if(predicate.test(this)){
            return Optional.of(this);
        }
        return Optional.empty();
    }
}
