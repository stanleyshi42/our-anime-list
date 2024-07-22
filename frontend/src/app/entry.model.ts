export interface Entry {
  id: number;
  userId: number;
  malId: number;
  title: string;
  totalEpisodes: number;
  episodesWatched: number;
  genres: string[];
  status: string;
  score: number;
  favorite: boolean;
  durationMinutes: number;
}
