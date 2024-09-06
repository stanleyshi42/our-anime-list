export class Entry {
  // Non-optional values
  userId: number;
  malId: number;

  // Non-optional values; using malId, get these from Jikan API
  title: string;
  totalEpisodes: number;
  durationMinutes: number;
  imageUrl: string;

  // Optional values; the backend will set default values if these values are null or invalid
  id: number; // Backend will always auto generate this
  episodesWatched: number;
  status: string;
  score: number;
  favorite: boolean;

  constructor(
    userId: number,
    malId: number,
    title: string,
    totalEpisodes: number,
    durationMinutes: number,
    imageUrl: string
  ) {
    this.userId = userId;
    this.malId = malId;

    this.title = title;
    this.totalEpisodes = totalEpisodes;
    this.durationMinutes = durationMinutes;
    this.imageUrl = imageUrl;

    this.id = 0;
    this.episodesWatched = 0;
    this.status = 'PLAN_TO_WATCH';
    this.score = 0;
    this.favorite = false;
  }
}
