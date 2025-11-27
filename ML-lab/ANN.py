import numpy as np

class NeuralNetwork:
    def __init__(self, input_size, hidden_size, output_size):
        """
        Initialize the Neural Network with random weights and biases.
        """
        # Seed for reproducibility
        np.random.seed(42)
        
        # Initialize weights with values between -1 and 1
        # Weights between Input Layer -> Hidden Layer
        self.weights_input_hidden = 2 * np.random.random((input_size, hidden_size)) - 1
        # Weights between Hidden Layer -> Output Layer
        self.weights_hidden_output = 2 * np.random.random((hidden_size, output_size)) - 1
        
        # Initialize biases
        self.bias_hidden = np.random.randn(1, hidden_size)
        self.bias_output = np.random.randn(1, output_size)
        
        # Placeholders for intermediate values (needed for backprop)
        self.hidden_layer_activation = None
        self.hidden_layer_output = None
        self.output_layer_activation = None
        self.predicted_output = None

    def sigmoid(self, x):
        """
        Sigmoid activation function.
        Maps any value to a value between 0 and 1.
        """
        return 1 / (1 + np.exp(-x))

    def sigmoid_derivative(self, x):
        """
        Derivative of the Sigmoid function.
        Used for calculating gradients during backpropagation.
        x is the output of the sigmoid function (not the raw input).
        """
        return x * (1 - x)

    def forward(self, inputs):
        """
        Forward propagation step.
        """
        # 1. Input -> Hidden Layer
        # Dot product of inputs and weights + bias
        self.hidden_layer_activation = np.dot(inputs, self.weights_input_hidden) + self.bias_hidden
        # Apply activation function
        self.hidden_layer_output = self.sigmoid(self.hidden_layer_activation)
        
        # 2. Hidden Layer -> Output Layer
        self.output_layer_activation = np.dot(self.hidden_layer_output, self.weights_hidden_output) + self.bias_output
        # Apply activation function
        self.predicted_output = self.sigmoid(self.output_layer_activation)
        
        return self.predicted_output

    def backward(self, inputs, expected_output, learning_rate):
        """
        Backpropagation step.
        Calculates gradients and updates weights and biases.
        """
        # --- Calculate Error ---
        error = expected_output - self.predicted_output
        
        # --- Output Layer Gradients ---
        # d_cost/d_output * d_output/d_activation
        # Error * Derivative of Sigmoid at Output
        d_predicted_output = error * self.sigmoid_derivative(self.predicted_output)
        
        # --- Hidden Layer Gradients ---
        # Propagate the error backwards to the hidden layer
        error_hidden_layer = d_predicted_output.dot(self.weights_hidden_output.T)
        d_hidden_layer = error_hidden_layer * self.sigmoid_derivative(self.hidden_layer_output)
        
        # --- Update Weights and Biases ---
        # Update Output Layer weights: Change = Hidden_Output.T dot Delta_Output
        self.weights_hidden_output += self.hidden_layer_output.T.dot(d_predicted_output) * learning_rate
        self.bias_output += np.sum(d_predicted_output, axis=0, keepdims=True) * learning_rate
        
        # Update Input Layer weights: Change = Input.T dot Delta_Hidden
        self.weights_input_hidden += inputs.T.dot(d_hidden_layer) * learning_rate
        self.bias_hidden += np.sum(d_hidden_layer, axis=0, keepdims=True) * learning_rate

    def train(self, inputs, expected_output, epochs, learning_rate):
        """
        Training loop that executes forward and backward passes.
        """
        print(f"Training for {epochs} epochs...")
        for epoch in range(epochs):
            # Forward pass
            self.forward(inputs)
            
            # Backward pass
            self.backward(inputs, expected_output, learning_rate)
            
            # Print loss occasionally
            if (epoch % 1000) == 0:
                loss = np.mean(np.square(expected_output - self.predicted_output))
                print(f"Epoch {epoch}: Loss {loss:.6f}")

# --- Testing the Implementation ---

if __name__ == "__main__":
    # 1. Prepare Data: XOR Logic Gate
    # XOR is 1 only if inputs are different (0,1 or 1,0)
    inputs = np.array([
        [0, 0],
        [0, 1],
        [1, 0],
        [1, 1]
    ])
    
    # Expected outputs for XOR
    expected_output = np.array([
        [0],
        [1],
        [1],
        [0]
    ])

    # 2. Initialize Neural Network
    # Input size: 2 (two bits)
    # Hidden size: 4 (neurons in hidden layer - tunable)
    # Output size: 1 (result is 0 or 1)
    nn = NeuralNetwork(input_size=2, hidden_size=4, output_size=1)

    # 3. Train the Network
    nn.train(inputs, expected_output, epochs=10000, learning_rate=0.1)

    # 4. Test the Trained Network
    print("\n--- Testing Results ---")
    predicted = nn.forward(inputs)
    
    for i in range(len(inputs)):
        print(f"Input: {inputs[i]} | Expected: {expected_output[i]} | Predicted: {predicted[i][0]:.4f} -> {round(predicted[i][0])}")