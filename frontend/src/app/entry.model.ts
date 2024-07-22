export interface Entry {
  // Non-optional values
  userId: number;
  malId: number;

  // Non-optional values; using malId, get these from Jikan API
  title: string;
  totalEpisodes: number;
  genres: string[];
  durationMinutes: number;
  imageUrl: string;

  // Optional values; the backend will set default values if these values are null or invalid
  id: number; // Backend will always auto generate this
  episodesWatched: number;
  status: string;
  score: number;
  favorite: boolean;
}
