package Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Wall implements Structure{
    private List<Block> blocks;


    @Override
    public Optional<Block> findBlockByColor(String color) {
        return findByPredicate(block -> block.getColor().equals(color)).stream().findFirst();
//      return blocks.stream()
//                .filter(block -> block.getColor().equals(color))
//                .findFirst();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return findByPredicate(block -> block.getMaterial().equals(material));
//        List<Block> blocksByMaterial = blocks.stream().
//                filter(block -> block.getMaterial().equals(material))
//                .collect(Collectors.toList());
//        return blocksByMaterial;
    }

    private List<Block> findByPredicate(Predicate<Block> predicate){
        return blocks.stream()
                .map(child-> child.getMachingObj(predicate))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    @Override
    public int count() {
        return blocks
                .stream()
                .mapToInt(Block::getChildrenCount)
                .sum();
    }
}
