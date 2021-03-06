import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Layer {

    private Type layerType;
    public Node[] nodes;
    public int layerCount;

    public Layer(int nodeCount, Type layerType) {
        nodes = new Node[nodeCount];

        IntStream.range(0, nodeCount).boxed().forEach(i -> nodes[i] = new Node(layerType));
    }

    public void updateNodeWeights(List<List<Double>> weights){
        IntStream.range(0, weights.size()).boxed().forEach(i -> nodes[i].updateWeights(weights.get(i)));
    }

    public List<List<Double>> calculateNodeOutputs(){
        return Stream.of(nodes).map(n -> n.calculateOutputs()).collect(Collectors.toList());
    }

}
