public enum API {
    IMDB_TOP_MOVIES("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json", new ContentExtractorIMDB()),
    NASA("https://api.nasa.gov/planetary/apod?api_key=evita.dog&start_date=2022-06-12&end_date=2022-06-14", new ContentExtractorNASA());

    // Todo atributo de enum deve ser private
    private final String url;
    private final ContentExtractor extractor;

    API(String url, ContentExtractor extractor) {
        this.url = url;
        this.extractor = extractor;
    }

    public String getUrl() {
        return url;
    }

    public ContentExtractor getExtractor() {
        return extractor;
    }
}
