import numpy as np
import matplotlib.pyplot as plt
from sklearn.datasets import make_blobs

class CustomKMeans:
    def __init__(self, k=3, max_iters=100, tol=0.0001):
        """
        Custom implementation of K-Means clustering.
        
        Args:
            k (int): Number of clusters.
            max_iters (int): Maximum number of iterations.
            tol (float): Tolerance for convergence (centroid shift).
        """
        self.k = k
        self.max_iters = max_iters
        self.tol = tol
        self.centroids = None
        self.labels = None

    def fit(self, X):
        """
        Compute k-means clustering.
        """
        n_samples, n_features = X.shape

        # 1. Initialization: Randomly select k data points as initial centroids
        np.random.seed(42)  # For reproducibility
        random_indices = np.random.choice(n_samples, self.k, replace=False)
        self.centroids = X[random_indices]

        for i in range(self.max_iters):
            # 2. Assignment Step: Assign each point to the nearest centroid
            self.labels = self._assign_clusters(X, self.centroids)

            # 3. Update Step: Calculate new centroids
            new_centroids = self._calculate_centroids(X, self.labels)

            # 4. Convergence Check: If centroids haven't moved significantly, stop
            shift = np.linalg.norm(self.centroids - new_centroids)
            if shift < self.tol:
                print(f"Converged at iteration {i} for K={self.k}")
                break
            
            self.centroids = new_centroids

    def _assign_clusters(self, X, centroids):
        """
        Helper: Calculates distance from every point to every centroid 
        and assigns the point to the closest one.
        """
        # Calculate Euclidean distances
        distances = np.linalg.norm(X[:, np.newaxis] - centroids, axis=2)
        # Return index of minimum distance
        return np.argmin(distances, axis=1)

    def _calculate_centroids(self, X, labels):
        """
        Helper: Calculates the mean position of points in each cluster.
        """
        centroids = np.zeros((self.k, X.shape[1]))
        for i in range(self.k):
            # Get points belonging to cluster i
            points = X[labels == i]
            if len(points) > 0:
                centroids[i] = np.mean(points, axis=0)
            else:
                # Handle empty cluster case by keeping old centroid or re-initializing
                centroids[i] = self.centroids[i] 
        return centroids

def run_demo():
    # --- 1. Generate Dataset ---
    print("Generating synthetic dataset...")
    # We create 4 distinct blobs of data to make the 'correct' K obvious (K=4)
    X, y_true = make_blobs(n_samples=400, centers=4, cluster_std=0.8, random_state=10)

    # --- 2. Define varying values of K to test ---
    k_values = [2, 3, 4, 5]
    
    # Setup the plot
    fig, axes = plt.subplots(2, 2, figsize=(12, 10))
    fig.suptitle('K-Means Clustering with Varying K', fontsize=16)
    axes = axes.flatten()

    # --- 3. Run Algorithm for each K and Visualize ---
    for idx, k in enumerate(k_values):
        print(f"Running K-Means for K={k}...")
        
        # Initialize and fit our custom model
        kmeans = CustomKMeans(k=k)
        kmeans.fit(X)
        
        # Plotting
        ax = axes[idx]
        
        # Scatter plot of the data points, colored by their assigned cluster
        scatter = ax.scatter(X[:, 0], X[:, 1], c=kmeans.labels, cmap='viridis', 
                             s=30, alpha=0.6, edgecolor='k')
        
        # Plot the final centroids as red X's
        ax.scatter(kmeans.centroids[:, 0], kmeans.centroids[:, 1], 
                   c='red', marker='x', s=200, linewidths=3, label='Centroids')
        
        ax.set_title(f'K = {k}')
        ax.legend(loc='upper right')
        ax.grid(True, linestyle='--', alpha=0.3)

    plt.tight_layout(rect=[0, 0.03, 1, 0.95])
    print("Plotting results...")
    plt.show()

if __name__ == "__main__":
    run_demo()