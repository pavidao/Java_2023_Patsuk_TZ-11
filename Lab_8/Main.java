import java.util.*;

class DogComment {
    private String text;
    private int likes;
    private int dislikes;

    public DogComment(String text, int likes, int dislikes) {
        this.text = text;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public int getLikes() {
        return likes;
    }
}

class DogVideo {
    private String title;
    private String url;
    private int views;
    private int likes;
    private int dislikes;
    private Set<DogComment> comments;

    public DogVideo(String title, String url, int views, int likes, int dislikes, Set<DogComment> comments) {
        this.title = title;
        this.url = url;
        this.views = views;
        this.likes = likes;
        this.dislikes = dislikes;
        this.comments = comments;
    }

    public int getViews() {
        return views;
    }

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public Set<DogComment> getComments() {
        return comments;
    }

    public String getUrl() {
        return url;
    }
    public String getTitle() {
        return title;
    }

    public void addComment(DogComment comment) {
        if (comments == null) {
            comments = new HashSet<>();
        }
        comments.add(comment);
    }
}

class DogBlog {
    private String blogger;
    private List<DogVideo> videos;
    private Map<String, Integer> viewsByVideoUrl;

    public DogBlog(String blogger, List<DogVideo> videos) {
        this.blogger = blogger;
        this.videos = videos;
        this.viewsByVideoUrl = new HashMap<>();
        for (DogVideo video : videos) {
            viewsByVideoUrl.put(video.getUrl(), video.getViews());
        }
    }

    public int getTotalViews() {
        int totalViews = 0;
        for (DogVideo video : videos) {
            totalViews += video.getViews();
        }
        return totalViews;
    }

    public boolean hasCommentWithMoreLikes() {
        for (DogVideo video : videos) {
            for (DogComment comment : video.getComments()) {
                if (comment.getLikes() > video.getLikes()) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<DogVideo> getVideosWithMostDislikes() {
        List<DogVideo> mostDislikedVideos = new ArrayList<>();
        int maxDislikes = Integer.MIN_VALUE;

        for (DogVideo video : videos) {
            if (video.getDislikes() > maxDislikes) {
                mostDislikedVideos.clear();
                mostDislikedVideos.add(video);
                maxDislikes = video.getDislikes();
            } else if (video.getDislikes() == maxDislikes) {
                mostDislikedVideos.add(video);
            }
        }

        return mostDislikedVideos;
    }

    public int getViewsForVideo(String videoUrl) {
        return viewsByVideoUrl.getOrDefault(videoUrl, 0);
    }

    public void updateViewsForVideo(String videoUrl, int views) {
        viewsByVideoUrl.put(videoUrl, views);
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating an example dog blog with multiple dog videos and comments
        Set<DogComment> comments1 = new HashSet<>(Arrays.asList(
                new DogComment("Cute dog!", 60, 2),
                new DogComment("Adorable content!", 15, 0)
        ));
        DogVideo video1 = new DogVideo("Puppies Playing in the Park", "https://example.com/puppies", 10000, 50, 8, comments1);

        Set<DogComment> comments2 = new HashSet<>(Arrays.asList(
                new DogComment("I love this breed!", 5, 10),
                new DogComment("Could use more dog tricks", 8, 3)
        ));
        DogVideo video2 = new DogVideo("Training Border Collies", "https://example.com/border-collies", 9000, 40, 8, comments2);

        List<DogVideo> dogVideos = Arrays.asList(video1, video2);
        DogBlog dogBlog = new DogBlog("DogLover", dogVideos);

        // Performing tasks
        // 1) Find the total number of views across all dog videos
        System.out.println("Total views across all dog videos: " + dogBlog.getTotalViews());

        // 2) Determine if there is a comment with more likes than its associated dog video
        System.out.println("Is there a comment with more likes than its associated dog video? " + dogBlog.hasCommentWithMoreLikes());

        // 3) Identify the dog video(s) with the most dislikes
        List<DogVideo> mostDislikedDogVideos = dogBlog.getVideosWithMostDislikes();
        if (!mostDislikedDogVideos.isEmpty()) {
            System.out.println("Dog video(s) with the most dislikes:");
            for (DogVideo dogVideo : mostDislikedDogVideos) {
                System.out.println("- " + dogVideo.getTitle());
            }
        } else {
            System.out.println("No dog videos with dislikes found.");
        }
    }
}
