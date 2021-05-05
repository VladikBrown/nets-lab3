function likeTrack(trackId) {
    let userId = $('#select-user-track' + trackId).val();
    let likeTrackButtonId = 'btn-likeTrack-' + trackId;
    $(document).ready(function () {
        $('#' + likeTrackButtonId).prop("disabled", true);
        $.put('/user/' + userId + 'track/' + trackId, {
            userId: userId,
            trackId: trackId
        }).done(function (data) {
        }).always(function () {
            $("#" + likeTrackButtonId).prop("disabled", false);
        })
    });
}

function likeAlbum(albumId) {
    let userId = $('#select-user-album' + albumId).val();
    let likeAlbumButtonId = 'btn-likeAlbum-' + albumId;
    $(document).ready(function () {
        $('#' + likeAlbumButtonId).prop("disabled", true);
        $.put('/user/' + userId + 'album/' + albumId, {
            userId: userId,
            albumId: albumId
        }).done(function (data) {
        }).always(function () {
            $("#" + likeAlbumButtonId).prop("disabled", false);
        })
    });
}

function likeArtist(artistId) {
    let userId = $('#select-user-artist' + artistId).val();
    let likeArtistButtonId = 'btn-likeArtist-' + artistId;
    $(document).ready(function () {
        $('#' + likeArtistButtonId).prop("disabled", true);
        $.put('/user/' + userId + 'artist/' + artistId, {
            userId: userId,
            artistId: artistId
        }).done(function (data) {
        }).always(function () {
            $("#" + likeArtistButtonId).prop("disabled", false);
        })
    });
}